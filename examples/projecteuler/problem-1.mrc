(def :io (require "io"))
(def :integer (require "integer"))

(def :n (integer.parse (io.read-line io.stdin)))

(def :sum (partial 1 [foldl + 0]))

(def :include? (function [:n] {
  (or { (= (% n 3) 0) } { (= (% n 5) 0) })
}))

(def :result (sum (filter include? (integer.range 1 n))))

(print result)
