(def :io (require "io"))
(def :integer (require "integer"))

(def :read-number (function [] {
  (integer.parse (io.read-line io.stdin))
}))

(def :contains (function [:list :value] {
  (if (nil? list) { false }
    { (if (= (head list) value) { true }
        { (recurse (tail list) value) } ) } )
}))

(var :numbers [])

(for-each [1 2 3 4 5] (function [:n] {
  (set! :numbers (cons (read-number) numbers))
}))

(def :query (read-number))

(if (contains numbers query)
  { (print (string-concat ["The number " query " appears in the first 5 numbers."])) }
  { (print (string-concat ["The number " query " doesn't appear in the first 5 numbers."])) })
