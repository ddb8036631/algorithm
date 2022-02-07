function solution(places) {
    const answer = [];

    for (let place of places) {
        place = place.map((s) => s.split(""));
        answer.push(check(place));
    }

    return answer;
}

function check(place) {
    const seats = [];

    for (let i = 0; i < 5; i++) {
        for (let j = 0; j < 5; j++) {
            if (place[i][j] == "P") {
                seats.push([i, j]);
            }
        }
    }

    for (let i = 0; i < seats.length - 1; i++) {
        for (let j = i + 1; j < seats.length; j++) {
            const [x1, y1] = seats[i];
            const [x2, y2] = seats[j];
            const dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
            if (dist == 1) return 0;
            if (dist == 2) {
                for (let x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                    for (let y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                        if (place[x][y] == "O") return 0;
                    }
                }
            }
        }
    }
    return 1;
}
