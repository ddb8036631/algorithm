from heapq import heappush, heappop

N = int(input())
max_heap, min_heap, answer = [], [], []

for _ in range(1, N + 1):
    x = int(input())

    if len(min_heap) == 0:
        heappush(min_heap, x)
    elif x > min_heap[0]:
        heappush(min_heap, x)
    else:
        heappush(max_heap, -x)

    if len(min_heap) - len(max_heap) == 2:
        heappush(max_heap, -heappop(min_heap))
    if len(max_heap) > len(min_heap):
        heappush(min_heap, -heappop(max_heap))

    answer.append(min_heap[0] if len(min_heap) > len(max_heap) else -max_heap[0])

print("\n".join(map(str, answer)))
