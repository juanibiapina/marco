# Marco

## Language Reference

### Literals

#### Numbers

All numbers of either positive or negative integers with no bounds.

```racket
1
-2
422319487132984710238740192387408937018470329874123123
```

#### Strings

Strings are delimited by double quotes.

```racket
"this is a string!"
```

#### Symbols

Symbols start with a `:`.

```racket
:a_symbol
```

### Bindings

`def` bindings are immutable. `var` bindings are mutable and can be changed
with `set!`.

```racket
(def :answer 42) // immutable binding

(var :done false) // mutable binding
(set! :done true) // mutation
```

### Functions

All functions are anonymous. To create a function use the `function` function.
To reuse a function, bind it with a `def` binding.

`function` takes a list of symbols and a block and returns an object that when
called will evaluate the block adding the arguments to the block closure.

```racket
(def :inc @"Increments a number"
  (function [:n] {
    (+ n 1)
  })
)
```

To call a function use parenthesis.

```racket
(inc 2)
```
