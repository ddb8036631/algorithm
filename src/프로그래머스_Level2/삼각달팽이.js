function solution(n) {
    let answer = []
    let map = Array.from(Array(n + 1), () => new Array(n + 1))
    let total = new Array(n + 1)
    total[1] = 1

    for (let idx = 2; idx <= n; idx++) total[idx] = total[idx - 1] + idx

    let cnt = 1,
        i = 1,
        j = 1

    while (cnt <= total[n]) {
        while (i <= n && map[i][j] == undefined && cnt <= total[n]) {
            map[i++][j] = cnt++
        }
        i--
        j++

        while (j <= n && map[i][j] == undefined && cnt <= total[n]) {
            map[i][j++] = cnt++
        }
        j -= 2
        i--

        while (map[i][j] == undefined && cnt <= total[n]) {
            map[i--][j--] = cnt++
        }
        i += 2
        j++
    }

    for (i = 1; i <= n; i++) {
        for (j = 1; j <= n; j++) {
            if (map[i][j] != undefined) answer.push(map[i][j])
        }
    }

    console.log(answer)

    return answer
}

solution(4)
