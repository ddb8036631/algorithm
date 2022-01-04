enToKo = {
    "q": "ㅂ",
    "w": "ㅈ",
    "e": "ㄷ",
    "r": "ㄱ",
    "t": "ㅅ",
    "y": "ㅛ",
    "u": "ㅕ",
    "i": "ㅑ",
    "o": "ㅐ",
    "p": "ㅔ",
    "a": "ㅁ",
    "s": "ㄴ",
    "d": "ㅇ",
    "f": "ㄹ",
    "g": "ㅎ",
    "h": "ㅗ",
    "j": "ㅓ",
    "k": "ㅏ",
    "l": "ㅣ",
    "z": "ㅋ",
    "x": "ㅌ",
    "c": "ㅊ",
    "v": "ㅍ",
    "b": "ㅠ",
    "n": "ㅜ",
    "m": "ㅡ",
}
consonants = {
    "ㅂ": (0, 0),
    "ㅈ": (0, 1),
    "ㄷ": (0, 2),
    "ㄱ": (0, 3),
    "ㅅ": (0, 4),
    "ㅁ": (1, 0),
    "ㄴ": (1, 1),
    "ㅇ": (1, 2),
    "ㄹ": (1, 3),
    "ㅎ": (1, 4),
    "ㅋ": (2, 0),
    "ㅌ": (2, 1),
    "ㅊ": (2, 2),
    "ㅍ": (2, 3),
}
vowels = {
    "ㅛ": (0, 5),
    "ㅕ": (0, 6),
    "ㅑ": (0, 7),
    "ㅐ": (0, 8),
    "ㅔ": (0, 9),
    "ㅗ": (1, 5),
    "ㅓ": (1, 6),
    "ㅏ": (1, 7),
    "ㅣ": (1, 8),
    "ㅠ": (2, 4),
    "ㅜ": (2, 5),
    "ㅡ": (2, 6),
}
sl, sr = input().split()
answer = 0
for ch in input():
    if enToKo[ch] in consonants:
        answer += (
            abs(consonants[enToKo[sl]][0] - consonants[enToKo[ch]][0])
            + abs(consonants[enToKo[sl]][1] - consonants[enToKo[ch]][1])
            + 1
        )
        sl = ch
    else:
        answer += (
            abs(vowels[enToKo[sr]][0] - vowels[enToKo[ch]][0]) + abs(vowels[enToKo[sr]][1] - vowels[enToKo[ch]][1]) + 1
        )
        sr = ch
print(answer)
