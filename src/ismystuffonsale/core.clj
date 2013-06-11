(ns ismystuffonsale.core
  (:use compojure.core)
  (:require [compojure.route :as route]
            [ismystuffonsale.persistence :as persistence]
            [ismystuffonsale.views.main :as main-views]
            [compojure.handler :as handler]))

(defn main-action [request]
  (let [user (persistence/create-user "pickdavid@gmail.com")]
    (do
      (persistence/create-item {:user user :title "foo" :url "http://www.foo.com"})
      (main-views/index-page (persistence/all-users)))))

(defroutes main-routes
           (GET "/" [] main-action)
           (route/not-found "<h1>Page not found</h1>"))

(def app
  (handler/site main-routes))
