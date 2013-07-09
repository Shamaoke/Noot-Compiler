L0:     PUSH         1         ; Declaring INT a
        PUSH         1         ; Declaring INT b
        PUSH         1         ; Declaring INT c
        PUSH         1         ; Declaring INT d
        PUSH         1         ; Declaring INT l
        PUSH         1         ; Declaring CHAR e
        PUSH         1         ; Declaring INT y
        LOADL        1
        STORE(1)     6[SB]     ; Assigning constant y
        PUSH         1         ; Declaring INT x
        LOADL        5
        STORE(1)     7[SB]     ; Assigning constant x
        PUSH         1         ; Declaring BOOL f
        PUSH         1         ; Declaring BOOL g
        PUSH         1         ; Declaring BOOL k
        PUSH         1         ; Declaring BOOL m
        LOAD(1)      7[SB]     ; Loading x
        STORE(1)     1[SB]     ; Assigning b
        LOAD(1)      1[SB]     ; Loading b for next expression
        STORE(1)     0[SB]     ; Assigning a
        LOAD(1)      1[SB]     ; Loading b
        LOADL        3
        LOADL        2
        CALL         mult      ; Multiplication
        CALL         add       ; Adition
        STORE(1)     2[SB]     ; Assigning c
        LOADA(1)     3[SB]     ; Loading address of d
        LOADL        69        ; Loading character
        CALL         put       ; Print character
        LOADL        110       ; Loading character
        CALL         put       ; Print character
        LOADL        116       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
        LOADL        114       ; Loading character
        CALL         put       ; Print character
        LOADL        32        ; Loading character
        CALL         put       ; Print character
        LOADL        105       ; Loading character
        CALL         put       ; Print character
        LOADL        110       ; Loading character
        CALL         put       ; Print character
        LOADL        116       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
        LOADL        103       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
        LOADL        114       ; Loading character
        CALL         put       ; Print character
        LOADL        58        ; Loading character
        CALL         put       ; Print character
        LOADL        32        ; Loading character
        CALL         put       ; Print character
        CALL         getint    ; Reading int d
        LOAD(1)      3[SB]     ; Loading d
        CALL         putint    ; Print int
        CALL         puteol
        LOADL        101       ; Loading character 'e'
        STORE(1)     5[SB]     ; Assigning e
        LOAD(1)      0[SB]     ; Loading a
        LOADL        4
        LOADL        1
        CALL         eq
        LOAD(1)      1[SB]     ; Loading b
        LOADL        4
        LOADL        1
        CALL         eq
        CALL         and
        LOAD(1)      3[SB]     ; Loading d
        LOADL        4
        LOADL        1
        CALL         eq
        CALL         or
        STORE(1)     8[SB]     ; Assigning f
        PUSH         1         ; Declaring INT h
        PUSH         1         ; Declaring INT i
        LOADA(1)     12[SB]    ; Loading address of h
        LOADL        69        ; Loading character
        CALL         put       ; Print character
        LOADL        110       ; Loading character
        CALL         put       ; Print character
        LOADL        116       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
        LOADL        114       ; Loading character
        CALL         put       ; Print character
        LOADL        32        ; Loading character
        CALL         put       ; Print character
        LOADL        105       ; Loading character
        CALL         put       ; Print character
        LOADL        110       ; Loading character
        CALL         put       ; Print character
        LOADL        116       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
        LOADL        103       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
        LOADL        114       ; Loading character
        CALL         put       ; Print character
        LOADL        58        ; Loading character
        CALL         put       ; Print character
        LOADL        32        ; Loading character
        CALL         put       ; Print character
        CALL         getint    ; Reading int h
        LOADA(1)     13[SB]    ; Loading address of i
        LOADL        69        ; Loading character
        CALL         put       ; Print character
        LOADL        110       ; Loading character
        CALL         put       ; Print character
        LOADL        116       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
        LOADL        114       ; Loading character
        CALL         put       ; Print character
        LOADL        32        ; Loading character
        CALL         put       ; Print character
        LOADL        105       ; Loading character
        CALL         put       ; Print character
        LOADL        110       ; Loading character
        CALL         put       ; Print character
        LOADL        116       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
        LOADL        103       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
        LOADL        114       ; Loading character
        CALL         put       ; Print character
        LOADL        58        ; Loading character
        CALL         put       ; Print character
        LOADL        32        ; Loading character
        CALL         put       ; Print character
        CALL         getint    ; Reading int i
        LOAD(1)      12[SB]    ; Loading h
        LOAD(1)      13[SB]    ; Loading i
        CALL         gt        ; Greater than
        STORE(1)     9[SB]     ; Assigning g
        LOAD(1)      9[SB]     ; Loading g
        LOADL        1         ; True Boolean
        LOADL        1
        CALL         eq
        JUMPIF(0)    L1[CB]    ; If (jump to else)
        PUSH         1         ; Declaring INT i
        PUSH         1         ; Declaring INT j
        LOADL        5
        STORE(1)     15[SB]    ; Assigning j
        LOAD(1)      15[SB]    ; Loading j
        LOAD(1)      14[SB]    ; Loading i
        CALL         gt        ; Greater than
        JUMP         L2[CB]    ; Else (jump over else)
L1:     LOADL        0         ; False Boolean
L2:     STORE(1)     10[SB]    ; Assigning k
        PUSH         1         ; Pushing for helper register 
        LOAD(1)      10[SB]    ; Loading k
        STORE(1)     16[SB]    ; Assigning temp
        LOAD(1)      16[SB]    ; Loading temp
        LOADL        1
        LOADL        1
        CALL         eq
        JUMPIF(0)    L3[CB]    ; Printing True or jump
        LOADL        116       ; Loading character
        CALL         put       ; Print character
        LOADL        114       ; Loading character
        CALL         put       ; Print character
        LOADL        117       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
        JUMP         L4[CB]    ; Printing False
L3:     LOADL        102       ; Loading character
        CALL         put       ; Print character
        LOADL        97        ; Loading character
        CALL         put       ; Print character
        LOADL        108       ; Loading character
        CALL         put       ; Print character
        LOADL        115       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
L4:     CALL         puteol
        LOAD(1)      16[SB]    ; Loading temp
        STORE(1)     11[SB]    ; Assigning m
L5:     LOAD(1)      11[SB]    ; Loading m
        LOADL        1         ; True Boolean
        LOADL        1
        CALL         eq
        JUMPIF(0)    L7[CB]    ; While (jump out)
        PUSH         1         ; Pushing for helper register 
        LOAD(1)      4[SB]     ; Loading l
        LOADL        1
        CALL         add       ; Adition
        STORE(1)     17[SB]    ; Assigning temp
        LOAD(1)      17[SB]    ; Loading temp
        CALL         putint    ; Print int
        CALL         puteol
        LOAD(1)      17[SB]    ; Loading temp
        STORE(1)     4[SB]     ; Assigning l
        LOAD(1)      4[SB]     ; Loading l
        LOADL        10
        CALL         gt        ; Greater than
        JUMPIF(0)    L6[CB]    ; If (jump to else)
        LOADL        0         ; False Boolean
        STORE(1)     11[SB]    ; Assigning m
L6:     JUMP         L5[CB]    ; Looping back
L7:     POP(0)       18
        HALT                   ; Generated by the Noot Compiler (2013/07/09 20:35)
