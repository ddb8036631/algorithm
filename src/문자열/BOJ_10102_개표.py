input()
s = input()
result = s.count("A") - s.count("B")
if result < 0:
    print("B")
elif result == 0:
    print("Tie")
else:
    print("A")
