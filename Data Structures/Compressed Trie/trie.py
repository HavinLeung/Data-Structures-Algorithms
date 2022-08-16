class CompressedTrie:
    def _print(self, indent, acc):
        acc.append(self.is_word)
        acc.append("\n")
        for k, v in sorted(self.children.items(), key=lambda x: x[0]):
            acc.append(indent + "-" + k + "-> ")
            v._print(indent + " " * (4 + len(k)), acc)

    def __repr__(self):
        acc = []
        self._print("", acc)
        return "".join(map(str, acc))

    def __init__(self, is_word=False):
        self.is_word = is_word
        self.children = {}

    def _common(s1, s2):
        if not s1 or not s2:
            return 0
        max_common = min(len(s1), len(s2))
        for i in range(max_common):
            if s1[i] != s2[i]:
                return i
        return max_common

    def _child_that_matches(self, path):
        for k, v in self.children.items():
            common = CompressedTrie._common(path, k)
            if common == 0:
                continue
            return k, v, common
        return None, None, None

    # path left
    def _insert(self, path):
        if path == "":
            self.is_word = True
            return
        key, child, common = self._child_that_matches(path)
        if key is None:
            child = CompressedTrie(True)
            self.children[path] = child
        else:
            if common == len(key):
                child._insert(path[common:])
            else:
                old_child = child
                new_child = CompressedTrie(False)
                new_child.children[key[common:]] = old_child
                new_child._insert(path[common:])
                self.children[path[:common]] = new_child
                del self.children[key]

    def insert(self, word: str) -> None:
        self._insert(word)

    def _search(self, path):
        if path == "":
            return self.is_word
        key, child, common = self._child_that_matches(path)
        if key is None:
            return False
        if common == len(key):
            return child._search(path[common:])
        return False

    def search(self, word: str) -> bool:
        return self._search(word)

    def startsWith(self, prefix: str) -> bool:
        if not prefix:
            return True
        key, child, common = self._child_that_matches(prefix)
        if key is None:
            return False
        if common == len(key):
            return child.startsWith(prefix[common:])
        if common == len(prefix):
            return True
        return False


class NaiveTrie:
    def __init__(self):
        self.is_word = False
        self.children = {}

    def insert(self, word):
        if not word:
            self.is_word = True
            return
        self.children[word[0]] = self.children.get(word[0], NaiveTrie())
        self.children[word[0]].insert(word[1:])

    def search(self, word):
        if not word:
            return self.is_word
        for k, v in self.children.items():
            if word[0] == k:
                return v.search(word[1:])
        return False

    def startsWith(self, word):
        if not word:
            return True
        for k, v in self.children.items():
            if word[0] == k:
                return v.startsWith(word[1:])
        return False


def test_equal():
    import random
    import string

    ct = CompressedTrie()
    nt = NaiveTrie()

    def check_equal(method, args):
        ct_val = getattr(ct, method)(*args)
        nt_val = getattr(nt, method)(*args)
        if ct_val == nt_val:
            return True
        else:
            print(method, args)
            print(nt_val)
            print(ct_val)
            return False

    def random_method():
        methods = ["insert", "search", "startsWith"]
        return random.choice(methods)

    def random_string(max_len=10):
        return "".join(
            random.choices(string.ascii_lowercase, k=random.randint(0, max_len))
        )

    def test(iterations=1000):
        operations = []
        for _ in range(iterations):
            method = random_method()
            args = [random_string()]
            operations.append((method, args))
            if not check_equal(method, args):
                print(operations)
                print(ct)
                assert False

    for _ in range(200):
        test(1000)


if __name__ == "__main__":
    test_equal()

