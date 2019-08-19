(ns magnet-uri.core
  (:import java.net.URLEncoder)
  (:require [clojure.string :as string]))

(defn encode
  [{:keys [xt dn tr] :as torrent-data}]
  (-> "magnet:?"
      (str (string/join "&" (map #(str "xt=" %1) xt)))
      (str "&")
      (str "&" "dn=" (URLEncoder/encode dn "UTF-8"))
      (str "&")
      (str (string/join "&" (map #(str "tr=" (URLEncoder/encode %1 "UTF-8")) tr)))))