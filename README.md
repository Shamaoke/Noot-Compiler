noot
=============

Noot Language and Compiler. This is me experimenting with programming language design. The compiler will compile Noot to TAM (Triangle Abstract Machine).

Code examples
-------------

```
start

int a, b, c, d;

a = b = 4;
c = b + 3 * 2;

read(d);
print(d + c);

end
```

```
start

int a;

a = {
		int h,i;
		read(h,i);
		(h > i);
	}

end
```

```
start

bool a,b;

b = true;

a = if a == true then {
		int i,j;
		j = 5;
		(j > i);
	}
else
	false;
fi

print(a);

end
```

```
start

bool a;
int b;

a := true;
b := 0;

while a == true do {
	b := b + 1;
	print(b);
	if b > 10 then { a = false; } fi;
} od

end
```