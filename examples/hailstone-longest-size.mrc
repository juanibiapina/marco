(def :longest-size (function [:n] {
  (def :helper (function [:n :size] {
    (if (= n 1)
        { (+ 1 size) }
        { (recurse (if (even? n)
                       { (/ n 2) }
                       { (+ (* 3 n) 1) })
                   (+ size 1)) })
  }))

  (helper n 0)
}))

(def :size-max (function [:n] {
  (def :helper (function [:n :current-max] {
    (if (= n 1)
        { current-max }
        { (recurse (- n 1) (max current-max (longest-size n))) })
  }))

  (helper n 1)
}))

(print (size-max 100))
