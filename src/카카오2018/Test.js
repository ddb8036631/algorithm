let converted = "";

let num = 16,
    radix = 2;

setInterval(() => {
    while (num > 0) {
        let quotient = num / radix;
        let remainder = num % radix;

        console.log("quotient: " + quotient + ", remainder: " + remainder);
        converted = remainder + "" + converted;
        console.log("converted : " + converted);

        num = parseInt(quotient);
    }
}, 1000);
