from collections import Counter
from itertools import chain

N, C = map(int, input().split())
c = Counter(input().split()).most_common()
l = list(c)
answer = list(chain(*[*map(lambda x: [x[0]] * x[1], l)]))

print(" ".join(answer))
