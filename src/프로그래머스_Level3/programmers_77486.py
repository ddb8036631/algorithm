def solution(enroll, referral, seller, amount):
    answer = []
    tree = {"-": "root"}
    sell = {"-": 0}

    for i in range(len(enroll)):
        child = enroll[i]
        parent = referral[i]
        tree[child] = parent
        sell[child] = 0

    for i in range(len(seller)):
        child = seller[i]
        parent = tree[child]
        money = amount[i] * 100
        sell[child] += money

        while True:
            commission = money // 10
            if commission == 0:
                break
            sell[child] -= commission
            sell[parent] += commission
            child = parent
            parent = tree[child]
            money = commission
            if parent == "root":
                break

    for name in enroll:
        answer.append(sell[name])

    return answer


# def solution(enroll, referral, seller, amount):
#     answer = [0] * len(enroll)
#     idx_list = {}
#     for idx, name in enumerate(enroll):
#         idx_list[name] = idx
#     for idx, name in enumerate(seller):
#         price = 100 * amount[idx]
#         answer[idx_list[name]] += price
#         while referral[idx_list[name]] != "-":
#             answer[idx_list[name]] -= price // 10
#             name = referral[idx_list[name]]
#             answer[idx_list[name]] += price // 10
#             price = price // 10
#             if price == 0:
#                 break
#         answer[idx_list[name]] -= price // 10

#     return answer


print(
    solution(
        ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"],
        ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"],
        ["young", "john", "tod", "emily", "mary"],
        [12, 4, 2, 5, 10],
    )
)
print(
    solution(
        ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"],
        ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"],
        ["sam", "emily", "jaimie", "edward"],
        [2, 3, 5, 4],
    )
)
