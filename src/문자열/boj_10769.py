s = input()
happyCnt, sadCnt = s.count(":-)"), s.count(":-(")

print("happy" if happyCnt > sadCnt else "sad" if happyCnt < sadCnt else "unsure" if happyCnt * sadCnt else "none")
