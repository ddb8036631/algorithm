TC = int(input())

for _ in range(TC):
    arr = input().split()
    num = float(arr[0])
    
    for val in arr[1:]:
        if val == "@": num *= 3
        elif val == "%": num += 5
        else: num -= 7

    print("{:.2f}".format(num))
