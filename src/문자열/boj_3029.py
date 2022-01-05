now_hour, now_min, now_sec = map(int, input().split(":"))
target_hour, target_min, target_sec = map(int, input().split(":"))

if now_hour == target_hour and now_min == target_min and now_sec == target_sec:
    print("24:00:00")
    exit(0)

if now_sec > target_sec:
    target_sec += 60
    target_min -= 1
if now_min > target_min:
    target_min += 60
    target_hour -= 1
if now_hour > target_hour:
    target_hour += 24

print("%02d:%02d:%02d" % (target_hour - now_hour, target_min - now_min, target_sec - now_sec))
