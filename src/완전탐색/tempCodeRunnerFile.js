Math.max(go(idx + 1, cnt), sum[idx + K - 1] - sum[idx - 1] + go(idx + K, cnt + 1));
        console.log("exclude : " + exclude + ", include : " + include);
        console.log("sum[idx+K-1] : " + sum[idx + K - 1] + ", sum[idx - 1] : " + sum[idx - 1]);
        console.log();