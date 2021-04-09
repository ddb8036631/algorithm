function solution(new_id) {
    new_id = new_id.toLowerCase();
    new_id = new_id.replace(/[^\w\-\.]/g, "");
    new_id = new_id.replace(/[\.]{2,}/g, ".");
    new_id = new_id.replace(/^\./g, "").replace(/\.$/g, "");

    if (!new_id) new_id = "a";

    if (new_id.length >= 16) new_id = new_id.substring(0, 15);
    new_id = new_id.replace(/\.$/g, "");

    if (new_id.length <= 2) new_id = new_id.padEnd(3, new_id[new_id.length - 1]);

    return new_id;
}

solution("...!@BaT#*..y.abcdefghijklm");
solution("z-+.^.");
solution("=.=");
solution("123_.def");
solution("abcdefghijklmn.p");
