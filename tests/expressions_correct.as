L0:     PUSH         1         ; Declaring INT i1
        PUSH         1         ; Declaring INT i2
        PUSH         1         ; Declaring BOOL b1
        PUSH         1         ; Declaring CHAR c1
        PUSH         1         ; Declaring CHAR c2
        PUSH         1         ; Declaring INT ic1
        LOADL        1
        STORE(1)     5[SB]     ; Assigning constant ic1
        PUSH         1         ; Declaring INT ic2
        LOADL        2
        STORE(1)     6[SB]     ; Assigning constant ic2
        PUSH         1         ; Declaring BOOL bc1
        LOADL        1         ; True Boolean
        STORE(1)     7[SB]     ; Assigning constant bc1
        PUSH         1         ; Declaring CHAR cc1
        LOADL        99        ; Loading character 'c'
        STORE(1)     8[SB]     ; Assigning constant cc1
        LOADL        16
        LOADL        2
        LOADL        8
        CALL         neg       ; Integer negation
        CALL         mult      ; Multiplication
        CALL         add       ; Adition
        LOADL        0
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
        LOADL        1
        STORE(1)     0[SB]     ; Assigning i1
        LOADL        2
        STORE(1)     1[SB]     ; Assigning i2
        LOADL        12
        LOADL        5
        CALL         div       ; Devide
        LOADL        5
        CALL         mult      ; Multiplication
        LOADL        12
        LOADL        5
        CALL         mod       ; Modulo
        CALL         add       ; Adition
        LOADL        12
        LOADL        1
        CALL         eq
        LOADL        6
        LOADL        6
        CALL         ge        ; Greater than or equal
        CALL         and
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
        LOAD(1)      0[SB]     ; Loading i1
        LOAD(1)      1[SB]     ; Loading i2
        CALL         lt        ; Less than
        LOAD(1)      5[SB]     ; Loading ic1
        LOAD(1)      6[SB]     ; Loading ic2
        CALL         le        ; Less than or equal
        CALL         and
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
        LOAD(1)      5[SB]     ; Loading ic1
        LOAD(1)      6[SB]     ; Loading ic2
        CALL         mult      ; Multiplication
        LOAD(1)      1[SB]     ; Loading i2
        LOAD(1)      5[SB]     ; Loading ic1
        CALL         sub       ; Subtracting
        CALL         gt        ; Greater than
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
        STORE(1)     3[SB]     ; Assigning c1
        LOADL        97        ; Loading character 'a'
        STORE(1)     4[SB]     ; Assigning c2
        LOAD(1)      3[SB]     ; Loading c1
        LOAD(1)      4[SB]     ; Loading c2
        LOADL        1
        CALL         eq
        LOAD(1)      8[SB]     ; Loading cc1
        LOADL        98        ; Loading character 'b'
        LOADL        1
        CALL         ne        ; Not equal
        LOADL        0         ; False Boolean
        CALL         not       ; Boolean negation
        CALL         or
        CALL         and
        LOADL        1
        LOADL        1
        CALL         eq
        JUMPIF(0)    L9[CB]    ; Printing True or jump
        LOADL        116       ; Loading character
        CALL         put       ; Print character
        LOADL        114       ; Loading character
        CALL         put       ; Print character
        LOADL        117       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
        JUMP         L10[CB]   ; Printing False
L9:     LOADL        102       ; Loading character
        CALL         put       ; Print character
        LOADL        97        ; Loading character
        CALL         put       ; Print character
        LOADL        108       ; Loading character
        CALL         put       ; Print character
        LOADL        115       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
L10:    CALL         puteol
        LOADL        1         ; True Boolean
        STORE(1)     2[SB]     ; Assigning b1
        LOADL        0         ; False Boolean
        CALL         not       ; Boolean negation
        LOAD(1)      2[SB]     ; Loading b1
        LOAD(1)      7[SB]     ; Loading bc1
        LOADL        1
        CALL         eq
        CALL         and
        LOADL        1         ; True Boolean
        LOADL        0         ; False Boolean
        LOADL        1
        CALL         ne        ; Not equal
        CALL         or
        LOADL        1
        LOADL        1
        CALL         eq
        JUMPIF(0)    L11[CB]   ; Printing True or jump
        LOADL        116       ; Loading character
        CALL         put       ; Print character
        LOADL        114       ; Loading character
        CALL         put       ; Print character
        LOADL        117       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
        JUMP         L12[CB]   ; Printing False
L11:    LOADL        102       ; Loading character
        CALL         put       ; Print character
        LOADL        97        ; Loading character
        CALL         put       ; Print character
        LOADL        108       ; Loading character
        CALL         put       ; Print character
        LOADL        115       ; Loading character
        CALL         put       ; Print character
        LOADL        101       ; Loading character
        CALL         put       ; Print character
L12:    CALL         puteol
        POP(0)       9
        HALT                   ; Generated by the Noot Compiler (2013/07/08 18:24)
