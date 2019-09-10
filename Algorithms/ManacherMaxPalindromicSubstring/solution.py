class Solution:
    def preProcessString(self, s: str) -> str:
        '''
        "hello" -> "^#h#e#l#l#o#$"
        '''
        return '^#' + ''.join([x + '#' for x in s]) + '$'

    def longestPalindrome(self, s: str) -> str:
        # Manacher's algo - O(N) (hard to prove O(N) though lol)
        original = s
        s = self.preProcessString(s)
        L = len(s)
        lengths = [0]*L
        for center in range(1, L-1):
            # boundary of the palindrome that we "know" exists
            left = center - lengths[center]
            right = center + lengths[center]

            # try to expand
            while s[left - 1] == s[right + 1]:  # don't need to boundary check since we have special start/end chars
                left -= 1
                right += 1
            lengths[center] = center - left

            # mirror over
            for i in range(left + 1, center):
                copy = lengths[i] if lengths[i] < i-left else i-left
                lengths[2*center-i] = copy
        maxlen = max(lengths)
        index = lengths.index(maxlen)
        left = index-maxlen
        left //= 2
        return original[left:left+maxlen]

a = Solution()
assert(a.longestPalindrome('babad') in ('bab', 'aba'))     # 'bab' or 'aba' are both valid
assert(a.longestPalindrome('cbbd') == 'bb')      # 'bb' is valid
assert(a.longestPalindrome('racecar') == 'racecar')
assert(a.longestPalindrome('aaaaab') == 'aaaaa')
assert(a.longestPalindrome('aaaaaaaa') == 'aaaaaaaa')
print("Success!")

