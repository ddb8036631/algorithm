function solution(a) {
    let len = a.length;
    
    if(len == 1) return 1;

    let answer = 2;
    let left = new Array(len),
        right = new Array(len);

    left[0] = a[0];
    right[len - 1] = a[len - 1];

    for (let i = 1; i < len; i++) left[i] = Math.min(left[i - 1], a[i]);
    for (let i = len - 2; i >= 0; i--) right[i] = Math.min(right[i + 1], a[i]);

    for (let i = 1; i <= len - 2; i++) {
        if ((left[i - 1] < a[i] && a[i] < right[i + 1]) || (right[i + 1] < a[i] && a[i] < left[i - 1]) || (left[i - 1] > a[i] && right[i + 1] > a[i])) answer++;
    }

    return answer;
}

solution([9, -1, -5]);
solution([-16, 27, 65, -2, 58, -92, -71, -68, -61, -33]);
solution([1]);
