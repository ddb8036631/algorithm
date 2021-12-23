arr = [0] * 251
arr[0], arr[1] = 1, 1

for i in range(2, 251):
    arr[i] = arr[i - 1] + 2 * arr[i - 2]

while True:
    try:
        print(arr[int(input())])
    except:
        break
