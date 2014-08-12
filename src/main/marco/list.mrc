(def :cons (function [:head :tail] {
  (pair head tail)
}))

(def :head (function [:list] {
  (first list)
}))

(def :tail (function [:list] {
  (second list)
}))

(def :length (function [:list] {
  (def :helper (function [:list :size] {
    (if (nil? list) { size }
      { (recurse (tail list) (+ size 1)) })
  }))

  (helper list 0)
}))

(def :list? (function [:list] {
  (if (nil? list) { true } {
    (if (pair? list) {
      (recurse (tail list))
    } {
      false
    })
  })
}))

(export [:cons :length :list? :head :tail])
