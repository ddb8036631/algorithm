from itertools import combinations


def solution(info, query):
    answer = []
    dic = {}

    for i in info:
        info_splited = i.split()
        cond = info_splited[:-1]
        score = int(info_splited[-1])
        for ii in range(5):
            comb = list(combinations(range(4), ii))

            for selected in comb:
                tmp = cond[:]
                for idx in selected:
                    tmp[idx] = "-"
                key = "".join(tmp)

                if key in dic:
                    dic[key].append(score)
                else:
                    dic[key] = [score]

    for val in dic.values():
        val.sort()

    for q in query:
        query_splited = q.replace(" and ", " ").split()
        key = "".join(query_splited[:-1])
        target = int(query_splited[-1])

        if key not in dic:
            answer.append(0)
            continue

        data = dic[key]
        low, high = 0, len(data) - 1

        while low <= high:
            mid = (low + high) // 2
            if data[mid] >= target:
                high = mid - 1
            else:
                low = mid + 1

        answer.append(len(data) - low)

    return answer


print(
    solution(
        [
            "java backend junior pizza 150",
            "python frontend senior chicken 210",
            "python frontend senior chicken 150",
            "cpp backend senior pizza 260",
            "java backend junior chicken 80",
            "python backend senior chicken 50",
        ],
        [
            "java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200",
            "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150",
            "- and - and - and chicken 100",
            "- and - and - and - 150",
        ],
    )
)
