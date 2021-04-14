function solution(nums) {
    const SIZE = 3000;
    let sosu = Array(SIZE).fill(true);
    let answer = 0;
    sosu[0] = sosu[1] = false;

    for (let i = 2; i * i < SIZE; i++) {
        if (!sosu[i]) continue;

        for (let j = i * i; j < SIZE; j += i) {
            sosu[j] = false;
        }
    }

    for (let i = 0; i < nums.length - 2; i++) {
        for (let j = i + 1; j < nums.length - 1; j++) {
            for (let k = j + 1; k < nums.length; k++) {
                let sum = nums[i] + nums[j] + nums[k];

                if (sosu[sum]) answer++;
            }
        }
    }

    return answer;
}

solution([1, 2, 3, 4]);
solution([1, 2, 7, 6, 4]);
