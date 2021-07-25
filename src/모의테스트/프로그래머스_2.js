function solution(numbers) {
    return numbers.map((num) => {
        let arr = num.toString(2).split("");

        for (let i = arr.length - 1; i >= 0; i--) {
            if (arr[i] === "0") {
                if (i == arr.length - 1) {
                    arr[i] = "1";
                    return parseInt(arr.join(""), 2);
                } else {
                    arr[i] = "1";
                    arr[i + 1] = "0";
                    return parseInt(arr.join(""), 2);
                }
            }
        }

        arr.unshift("1");
        arr[1] = "0";
        return parseInt(arr.join(""), 2);
    });
}

console.log(solution([2, 7]));
console.log(solution([2, 3, 4, 5, 6]));
