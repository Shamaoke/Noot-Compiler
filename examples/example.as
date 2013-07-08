L0:     PUSH         1         ; Declaring INT a
        PUSH         1         ; Declaring INT b
        PUSH         1         ; Declaring INT c
        PUSH         1         ; Declaring INT d
        PUSH         1         ; Declaring INT l
        PUSH         1         ; Declaring INT y
        LOADL        1
        STORE(1)     5[SB]     ; Assigning constant y
        PUSH         1         ; Declaring CHAR e
        PUSH         1         ; Declaring BOOL f
        PUSH         1         ; Declaring BOOL g
        PUSH         1         ; Declaring BOOL k
        LOADL        1         ; True Boolean
        JUMPIF(0)    L1[CB]    ; If (jump to else)
        PUSH         1         ; Declaring INT i
        PUSH         1         ; Declaring INT j
        LOADL        5
        STORE(1)     11[SB]    ; Assigning j
        LOAD(1)      11[SB]    ; Loading j
        LOAD(1)      10[SB]    ; Loading i
        CALL         gt        ; Greater than
        JUMP         L2[CB]    ; Else (jump over else)
L1:     LOADL        0         ; False Boolean
L2:     STORE(1)     9[SB]     ; Assigning k
        LOADL        3
        LOADL        0
        CALL         div       ; Devide
        STORE(1)     0[SB]     ; Assigning a
        LOADL        1         ; True Boolean
        STORE(1)     9[SB]     ; Assigning k
L3:     LOAD(1)      9[SB]     ; Loading k
        LOADL        1         ; True Boolean
        LOADL        1
        CALL         eq
        JUMPIF(0)    L5[CB]    ; While (jump out)
        PUSH         1         ; Pushing for helper register 
        LOAD(1)      4[SB]     ; Loading l
        LOADL        1
        CALL         add       ; Adition
        STORE(1)     12[SB]    ; Assigning temp
        LOAD(1)      12[SB]    ; Loading temp
        CALL         putint    ; Print int
        CALL         puteol
        LOAD(1)      12[SB]    ; Loading temp
        STORE(1)     4[SB]     ; Assigning l
        LOAD(1)      4[SB]     ; Loading l
        LOADL        10
        CALL         gt        ; Greater than
        JUMPIF(0)    L4[CB]    ; If (jump to else)
        LOADL        0         ; False Boolean
        STORE(1)     9[SB]     ; Assigning k
L4:     JUMP         L3[CB]    ; Looping back
L5:     LOAD(1)      9[SB]     ; Loading k
        LOADL        1         ; True Boolean
        LOADL        1
        CALL         eq
        JUMPIF(0)    L6[CB]    ; If (jump to else)
        LOADA(1)     9[SB]     ; Loading address of k
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
        LOADL        98        ; Loading character
        CALL         put       ; Print character
        LOADL        111       ; Loading character
        CALL         put       ; Print character
        LOADL        111       ; Loading character
        CALL         put       ; Print character
        LOADL        108       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
        LOADL        97        ; Loading character
        CALL         put       ; Print character
        LOADL        110       ; Loading character
        CALL         put       ; Print character
        LOADL        58        ; Loading character
        CALL         put       ; Print character
        LOADL        32        ; Loading character
        CALL         put       ; Print character
        CALL         getint    ; Reading boolean k
        LOAD(1)      9[SB]     ; Loading k for next expression
        JUMP         L7[CB]    ; Else (jump over else)
L6:     LOADL        1         ; True Boolean
L7:     STORE(1)     9[SB]     ; Assigning k
        PUSH         1         ; Declaring INT a
        LOADA(1)     13[SB]    ; Loading address of a
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
        CALL         getint    ; Reading int a
        LOAD(1)      13[SB]    ; Loading a for next expression
        CALL         putint    ; Print int
        CALL         puteol
        POP(0)       14
        HALT                   ; Generated by the Noot Compiler (2013/07/08 14:24)
