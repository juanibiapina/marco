(def :io (require "io"))
(def :integer (require "integer"))
(def :stream (require "stream"))

(def :make-fib (function [] {
  (def :helper (function [:a :b] {
    (stream.cons a (function [] { (helper b (+ a b)) }))
  }))

  (helper 1 1)
}))

(def :sum (partial 1 [foldl + 0]))

(def :n (integer.parse (io.read-line io.stdin)))

(def :fib (make-fib))

(def :include? even?)

(print (sum (stream.take-while (function [:e] { (< e n) }) (stream.filter include? fib))))
