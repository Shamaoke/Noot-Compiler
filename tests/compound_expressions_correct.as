L0:     PUSH         1         ; Declaring INT i1
        PUSH         1         ; Declaring INT i2
        PUSH         1         ; Declaring INT i3
        PUSH         1         ; Declaring BOOL b1
        PUSH         1         ; Declaring CHAR c1
        LOADL        1
        STORE(1)     0[SB]     ; Assigning i1
        LOADL        2
        STORE(1)     1[SB]     ; Assigning i2
        LOADL        3
        STORE(1)     2[SB]     ; Assigning i3
        PUSH         1         ; Declaring INT i1
        LOADL        3
        STORE(1)     5[SB]     ; Assigning constant i1
        PUSH         1         ; Declaring INT i2
        LOADL        5
        STORE(1)     6[SB]     ; Assigning i2
        PUSH         1         ; Declaring INT i3
        LOADL        2
        STORE(1)     7[SB]     ; Assigning constant i3
        LOAD(1)      5[SB]     ; Loading i1
        LOAD(1)      7[SB]     ; Loading i3
        CALL         add       ; Adition
        LOAD(1)      6[SB]     ; Loading i2
        LOADL        1
        CALL         eq
        LOADL        1
        LOADL        1
        CALL         eq
        JUMPIF(0)    L1[CB]    ; Printing True or jump
        LOADL        116       ; Loading character
        CALL         put       ; Print character
        LOADL        114       ; Loading character
        CALL         put       ; Print character
        LOADL        117       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
        JUMP         L2[CB]    ; Printing False
L1:     LOADL        102       ; Loading character
        CALL         put       ; Print character
        LOADL        97        ; Loading character
        CALL         put       ; Print character
        LOADL        108       ; Loading character
        CALL         put       ; Print character
        LOADL        115       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
L2:     CALL         puteol
        LOAD(1)      1[SB]     ; Loading i2
        CALL         putint    ; Print int
        CALL         puteol
        LOADL        0         ; False Boolean
        STORE(1)     3[SB]     ; Assigning b1
        PUSH         1         ; Declaring BOOL b1
        LOADL        1         ; True Boolean
        STORE(1)     8[SB]     ; Assigning constant b1
        PUSH         1         ; Pushing for helper register 
        LOAD(1)      8[SB]     ; Loading b1
        STORE(1)     9[SB]     ; Assigning temp
        LOAD(1)      9[SB]     ; Loading temp
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
        LOAD(1)      9[SB]     ; Loading temp
        LOADL        1
        LOADL        1
        CALL         eq
        JUMPIF(0)    L5[CB]    ; Printing True or jump
        LOADL        116       ; Loading character
        CALL         put       ; Print character
        LOADL        114       ; Loading character
        CALL         put       ; Print character
        LOADL        117       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
        JUMP         L6[CB]    ; Printing False
L5:     LOADL        102       ; Loading character
        CALL         put       ; Print character
        LOADL        97        ; Loading character
        CALL         put       ; Print character
        LOADL        108       ; Loading character
        CALL         put       ; Print character
        LOADL        115       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
L6:     CALL         puteol
        LOAD(1)      3[SB]     ; Loading b1
        LOADL        1
        LOADL        1
        CALL         eq
        JUMPIF(0)    L7[CB]    ; Printing True or jump
        LOADL        116       ; Loading character
        CALL         put       ; Print character
        LOADL        114       ; Loading character
        CALL         put       ; Print character
        LOADL        117       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
        JUMP         L8[CB]    ; Printing False
L7:     LOADL        102       ; Loading character
        CALL         put       ; Print character
        LOADL        97        ; Loading character
        CALL         put       ; Print character
        LOADL        108       ; Loading character
        CALL         put       ; Print character
        LOADL        115       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
L8:     CALL         puteol
        LOADL        97        ; Loading character 'a'
        STORE(1)     4[SB]     ; Assigning c1
        PUSH         1         ; Declaring CHAR c1
        LOADL        98        ; Loading character 'b'
        STORE(1)     10[SB]    ; Assigning c1
        LOAD(1)      10[SB]    ; Loading c1 for next expression
        CALL         put       ; Print character
        CALL         puteol
        LOAD(1)      4[SB]     ; Loading c1
        CALL         put       ; Print character
        CALL         puteol
        POP(0)       11
        HALT                   ; Generated by the Noot Compiler (2013/07/08 20:46)
