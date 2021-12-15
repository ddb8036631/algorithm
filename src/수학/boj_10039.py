N = [40 if score < 40 else score for score in list(map(int, [input() for _ in range(5)]))]
print(sum(N) // 5)
