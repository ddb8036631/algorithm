from itertools import zip_longest, chain

arr = [list(input()) for _ in range(5)]
print("".join(chain(*list(map(list, zip_longest(*arr, fillvalue=""))))))
