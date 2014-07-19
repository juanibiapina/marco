(def :io (require "io"))
(def :integer (require "integer"))

(def :n (integer.parse (io.read-line io.stdin)))

(def :factorial (function [:n] {
  (if (= n 0)
    { 1 }
    { (* n (recurse (- n 1))) })
}))

(print (factorial n))
