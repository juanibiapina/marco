(def :cons (function [:head :tail] {
  (with-meta (pair head tail) #{:length (+ 1 ((meta tail) :length))})
}))

(def :head (function [:list] {
  (first list)
}))

(def :tail (function [:list] {
  (second list)
}))

(def :length (function [:list] {
  ((meta list) :length)
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
