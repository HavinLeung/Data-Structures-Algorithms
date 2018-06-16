from quicksort import quicksort
import random

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

# random testing
for _ in range(20):
    test_list = []
    model_list = []
    for __ in range(1000):
        num = random.randint(-1000, 1000)
        test_list.append(num)
        model_list.append(num)
    quicksort(test_list)
    model_list.sort()
    # print("test_list: " + str(test_list))
    # print("model_list: " + str(model_list))
    assert test_list == model_list
print("All tests passed")