from quicksort import quicksort
import random
import tqdm

# reversed
test_list = [i for i in range(100, -100, -1)]
# print(test_list)
model_list = test_list[:] #deep copy
quicksort(test_list)
model_list.sort()
assert test_list == model_list

# all same
test_list = [100]*200
# print(test_list)
model_list = test_list[:] #deep copy
quicksort(test_list)
model_list.sort()
assert test_list == model_list

# empty list
test_list = []
# print(test_list)
model_list = test_list[:] #deep copy
quicksort(test_list)
model_list.sort()
assert test_list == model_list

print("Passed edge cases")

# random testing
print("Testing on random lists of size 10000")
for _ in tqdm.trange(100):
    test_list = []
    model_list = []
    for __ in range(10000):
        num = random.randint(-1000, 1000)
        test_list.append(num)
        model_list.append(num)
    quicksort(test_list)
    model_list.sort()
    # print("test_list: " + str(test_list))
    # print("model_list: " + str(model_list))
    assert test_list == model_list
print("All tests passed")
