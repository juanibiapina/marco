(def :factorial (function [:n] {
  (if (= n 0)
    { 1 }
    { (* n (recurse (- n 1))) })
}))

(print (factorial 10))
