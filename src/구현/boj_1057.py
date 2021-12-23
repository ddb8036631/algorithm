# n, a, b = map(int, input().split())
# arr = [False] * n
# arr[a - 1] = arr[b - 1] = True
# answer = -1
# cnt = 0

# while len(arr) != 1:
#     cnt += 1
#     tmp = []
#     found = False

#     for idx in range(0, len(arr), 2):
#         if idx + 1 < len(arr) and arr[idx] and arr[idx + 1]:
#             answer = cnt
#             found = True
#             break
#         elif arr[idx] or (idx + 1 < len(arr) and arr[idx + 1]) == True:
#             tmp.append(True)
#         else:
#             tmp.append(False)

#     if found:
#         break
#     arr = tmp


# print(answer)

n, a, b = map(int, input().split())
a -= 1
b -= 1
answer = 0

while a != b:
    answer += 1
    a //= 2
    b //= 2

print(answer)
