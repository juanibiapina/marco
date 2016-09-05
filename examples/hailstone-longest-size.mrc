(def :hailstone-size (function [:n] {
  (def :helper (function [:n :s] {
    (if (= n 1)
        { (+ 1 s) }
        { (recurse (if (even? n)
                       { (/ n 2) }
                       { (+ (* 3 n) 1) })
                   (+ s 1)) })
  }))

  (helper n 0)
}))

(def :max (function [:p1 :p2] {
  (if (> (second p1) (second p2))
    { p1 } { p2 })
}))

(def :size-max (function [:n] {
  (def :helper (function [:n :p] {
    (def :max-n (first p))
    (def :max-size (second p))

    (if (= n 1)
      { p }
      {
        (recurse (- n 1) (max p (pair n (hailstone-size n))))
      }
    )
  }))

  (helper n (pair 1 1))
}))

(print (size-max 100))
