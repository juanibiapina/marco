(def :io (require "io"))
(def :integer (require "integer"))

(def :n (integer.parse (io.read-line io.stdin)))

(def :sum (function [:list] {
  (if (nil? list) { 0 }
    { (+ (head list) (sum (tail list))) })
}))

(def :range (function [:start :end] {
  (def :helper (function [:start :end :acc] {
    (if (< end start) { acc }
      { (recurse start (- end 1) (cons end acc)) })
  }))

  (helper start (- end 1) [])
}))

(def :include? (function [:n] {
  (or { (= (% n 3) 0) } { (= (% n 5) 0) })
}))

(def :result (sum (filter (range 1 n) include?)))

(print result)
