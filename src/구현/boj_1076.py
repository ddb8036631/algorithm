a, b, c = [
    ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"].index(input())
    for _ in range(3)
]
print((10 * a + b) * 10 ** c)
