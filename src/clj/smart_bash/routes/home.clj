(ns smart-bash.routes.home
  (:require
    [clojure.java.shell :refer [sh]]
    [ctmx.core :as ctmx]
    [ctmx.render :as render]
    [hiccup.page :refer [html5]]
    [smart-bash.parse :as parse]))

(defn html-response [body]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body body})

(defn html5-response
  ([body]
   (html-response
    (html5
     [:head
      [:meta {:name "viewport"
              :content "width=device-width, initial-scale=1, shrink-to-fit=no"}]]
     [:body (render/walk-attrs body)]
     [:script {:src "https://unpkg.com/htmx.org@1.5.0"}]))))

(ctmx/defcomponent ^:endpoint root [req ^:long num-clicks command file]
  (case command
    "open" (prn (sh "open" file))
    (parse/parse)))

(defn home-routes []
  (ctmx/make-routes
   "/"
   (fn [req]
     (html5-response
      (root req)))))
