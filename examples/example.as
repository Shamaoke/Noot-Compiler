L0:     PUSH         1         ; Declaring INT a
        PUSH         1         ; Declaring INT b
        PUSH         1         ; Declaring INT c
        PUSH         1         ; Declaring INT d
        PUSH         1         ; Declaring INT l
        PUSH         1         ; Declaring INT k
        PUSH         1         ; Declaring CHAR e
        PUSH         1         ; Declaring BOOL f
        PUSH         1         ; Declaring BOOL g
        LOADL        4
        STORE(1)     1[SB]     ; Assigning b
        LOAD(1)      1[SB]     ; Loading b for next expression
        STORE(1)     0[SB]     ; Assigning a
        LOADL        5
        STORE(1)     3[SB]     ; Assigning d
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
        STORE(1)     7[SB]     ; Assigning f
        LOADL        102       ; Loading character 'f'
        CALL         put       ; Print character
        CALL         puteol
        LOAD(1)      7[SB]     ; Loading f
        CALL         putint    ; Print boolean
        CALL         puteol
        PUSH         1         ; Declaring INT h
        PUSH         1         ; Declaring INT i
        LOADA(1)     9[SB]     ; Loading address of h
        CALL         getint    ; Reading int h
        LOAD(1)      9[SB]     ; Loading h for next expression
        LOADA(1)     10[SB]    ; Loading address of i
        CALL         getint    ; Reading int i
        LOAD(1)      10[SB]    ; Loading i for next expression
        CALL         gt        ; Greater than
        STORE(1)     8[SB]     ; Assigning g
        LOAD(1)      8[SB]     ; Loading g
        LOADL        1         ; True Boolean
        LOADL        1
        CALL         eq
        JUMPIF(0)    L1[CB]    ; If
        PUSH         1         ; Declaring INT j
        LOADL        5
        STORE(1)     11[SB]    ; Assigning j
        LOAD(1)      11[SB]    ; Loading j for next expression
        JUMP         L2[CB]    ; Else
L1:     LOADL        4
L2:     STORE(1)     5[SB]     ; Assigning k
        LOADL        103       ; Loading character 'g'
        CALL         put       ; Print character
        CALL         puteol
        LOAD(1)      8[SB]     ; Loading g
        CALL         putint    ; Print boolean
        CALL         puteol
        LOADL        107       ; Loading character 'k'
        CALL         put       ; Print character
        CALL         puteol
        LOAD(1)      5[SB]     ; Loading k
        CALL         putint    ; Print int
        CALL         puteol
        POP(0)       0
        HALT                   ; Generated by the Noot Compiler (2013/07/06 14:57)