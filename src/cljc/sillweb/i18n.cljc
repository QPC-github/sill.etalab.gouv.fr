;; Copyright (c) 2019-2020 DINSIC, Bastien Guerry <bastien.guerry@data.gouv.fr>
;; SPDX-License-Identifier: EPL-2.0
;; License-Filename: LICENSES/EPL-2.0.txt

(ns sillweb.i18n
  (:require [taoensso.tempura :refer [tr]]
            [markdown-to-hiccup.core :as md]))

(defn md-to-string [s]
  (-> s (md/md->hiccup) (md/component)))

(def supported-languages #{"fr" "en" "de" "es" "it"})

(def localization
  ;; French translation
  {:fr
   {
    :public                  "Ce logiciel est développé et financé par l'administration publique."
    :about                   "À propos"
    :affiliation-placeholder "Par ex. DGFiP"
    :all                     "Tous"
    :back-to-website         "Retour au site principal"
    :clear-filters           "Effacer les filtres"
    :contact                 "Contact"
    :contact-baseline        "Envie de contribuer ? Un point à éclaircir ? Sollicitez-nous !"
    :contact-by-email        "Contacter par email"
    :contact-form            "Formulaire de contact"
    :context-of-use          "Contexte d'usage :"
    :contributors            "Contributeurs"
    :contributors-baseline   "La liste des organismes publics contributeurs"
    :count                   "Nombre"
    :download                "Télécharger"
    :email-placeholder       "Par ex. toto@modernisation.gouv.fr"
    :free-search             "Recherche libre"
    :function                "Fonction :"
    :go-to-source            "Voir le code source"
    :go-to-website           "Visiter le site web"
    :groupe                  "Groupe"
    :groups-count            "Décompte par groupe"
    :here                    "ici"
    :index-subtitle          "La liste des logiciels libres recommandés pour le secteur public."
    :index-title             "Socle Interministériel de Logiciels Libres"
    :keywords                "Liste des logiciels libres recommandés par l'État"
    :license                 "Licence"
    :licenses                "Licences"
    :licenses-count          "Décompte par licence"
    :main-etalab-website     "Site principal d'Etalab"
    :message-placeholder     "Votre message"
    :message-received        "Message reçu !"
    :message-received-ok     "Nous nous efforçons de répondre au plus vite."
    :mimall                  "Tout type"
    :mimdev                  "Développement (MIMDEV)"
    :mimo                    "Bureautique (MIMO)"
    :mimprod                 "Production (MIMPROD)"
    :name                    "Nom"
    :need-more-data          "En savoir plus sur l'utilisation de ce logiciel ?  [Écrivez-nous !](contact)"
    :no-sws-found            "Pas de logiciel trouvé : une autre idée de requête ?"
    :on-comptoir             "Fiche Comptoir du libre"
    :on-framalibre           "Sur Framalibre : "
    :one-sw                  "logiciel"
    :read-the-docs           "Lire la documentation"
    :recommended             "Recommandés"
    :recommended_version     "Version minimale recommandée"
    :similar-to              "Similaire à"
    :sort-alpha              "A-Z <=> Z-A"
    :source-code-available   ", code source disponible "
    :stats                   "Statistiques"
    :status                  "Statut"
    :submit                  "Envoyer"
    :subscribe-rss-flux      "S'abonner au flux RSS des derniers dépôts"
    :sws                     "logiciels"
    :tested                  "En observation"
    :unspecified             "Non spécifié"
    :updates                 "Mises à jour"
    :version                 "Version: "
    :warning-testing         "Ce logiciel est actuellement en observation."
    :website-developed-by    "Site développé par la mission "
    :why-this-website?       "Pourquoi ce site ?"
    :year                    "Année"
    :your-affiliation        "Votre organisme de rattachement"
    :your-email              "Votre adresse de courriel"
    :your-message            "Message"
    :your-name               "Votre nom"
    }
   :en
   {
    :public                  "This software is managed and funded by the french administration."
    :about                   "About"
    :affiliation-placeholder "E.g. DGFiP"
    :all                     "All"
    :back-to-website         "Back to the main website."
    :clear-filters           "Clear filters"
    :contact                 "Contact"
    :contact-baseline        "Want to contribute? A question? Contact us!"
    :contact-by-email        "Contact by email"
    :contact-form            "Contact form"
    :context-of-use          "Context of use:"
    :contributors            "Contributors"
    :contributors-baseline   "The list of contributing public sector agencies"
    :count                   "Quantity"
    :download                "Download"
    :email-placeholder       "E.g. toto@modernisation.gouv.fr"
    :free-search             "Free search"
    :function                "Function:"
    :go-to-source            "Browse the source code"
    :go-to-website           "Visit the website"
    :groupe                  "Group"
    :groups-count            "Count by group"
    :here                    "here"
    :index-subtitle          "This website lets you browse the catalog of recommended free software for the public sector."
    :index-title             "Recommended free software for the public sector"
    :keywords                "List of recommended software by the public sector"
    :license                 "License"
    :licenses                "Licenses"
    :licenses-count          "Count by license"
    :main-etalab-website     "Etalab main website"
    :message-placeholder     "Your message"
    :message-received        "Message received!"
    :message-received-ok     "We will reply as soon as possible."
    :mimall                  "All types"
    :mimdev                  "Development tools"
    :mimo                    "Office tools"
    :mimprod                 "Production tools"
    :name                    "Name"
    :need-more-data          "Want to know more about the use of this software?  [Contact us!](contact)"
    :no-sws-found            "No software found: try another query?"
    :on-comptoir             "On Comptoir du libre"
    :on-framalibre           "On Framalibre: "
    :one-sw                  "software"
    :read-the-docs           "Read the documentation"
    :recommended             "Recommended"
    :recommended_version     "Minimal recommended version"
    :similar-to              "Similar to"
    :sort-alpha              "A-Z <=> Z-A"
    :source-code-available   ", source code available "
    :stats                   "Statistics"
    :status                  "Status"
    :submit                  "Send"
    :subscribe-rss-flux      "Subscribe to the latest updates via RSS feed"
    :sws                     "software"
    :tested                  "Under observation"
    :unspecified             "Unspecified"
    :updates                 "Updates"
    :version                 "Version: "
    :warning-testing         "This software is currently being tested."
    :website-developed-by    "Website developed by "
    :why-this-website?       "Why this website?"
    :year                    "Year"
    :your-affiliation        "Your affiliation"
    :your-email              "Your email address"
    :your-message            "Message"
    :your-name               "Your name"
    }
   :de
   {
    :public                  "Dieses Software wird von der öffentlichen Verwaltung unterstützt und finanziert."
    :about                   "Über uns"
    :affiliation-placeholder "z.B. DGFiP"
    :all                     "Alle"
    :back-to-website         "Home"
    :clear-filters           "Filter löschen"
    :contact                 "Kontakt"
    :contact-baseline        "Sie haben Fragen oder Anregungen? Schreiben Sie uns!"
    :contact-by-email        "Kontakt per Email."
    :contact-form            "Kontaktformular"
    :context-of-use          "Nutzungskontext:"
    :contributors            "Beitragszahler"
    :contributors-baseline   "Beitragszahler des öffentlichen Sektors"
    :count                   "Menge"
    :download                "Download"
    :email-placeholder       "z.B. toto@modernisation.gouv.fr"
    :free-search             "Freie Suche"
    :function                "Funktion:"
    :go-to-source            "Quellcode sehen"
    :go-to-website           "Webseite besuchen"
    :groupe                  "Gruppe"
    :groups-count            "Nach Gruppe zählen"
    :here                    "hier"
    :index-subtitle          "Eine Liste aller freier Software, die in der öffentlichen Verwaltung regelmässig genutzt wird."
    :index-title             "Empfohlene open source Software für die öffentliche Verwaltung"
    :keywords                "Empfohlene open source Software für die öffentliche Verwaltung"
    :license                 "Lizenz"
    :licenses                "Lizenzen"
    :licenses-count          "Nach Lizenz zählen"
    :main-etalab-website     "Webseite von Etalab"
    :message-placeholder     "Ihre Nachricht"
    :message-received        "Nachricht erhalten!"
    :message-received-ok     "Sie hören bald von uns!"
    :mimall                  "Alle"
    :mimdev                  "Software-Entwicklung (MIMDEV)"
    :mimo                    "Bürosoftware (MIMO)"
    :mimprod                 "Produktion (MIMPROD)"
    :name                    "Name"
    :need-more-data          "Erfahren Sie mehr über die Verwendung dieser Software?  [Schreiben Sie uns!](contact)"
    :no-sws-found            "Keine Ergebnisse : Versuchen Sie einen anderen Suchbegriff."
    :on-comptoir             "Auf Comptoir du libre"
    :on-framalibre           "Auf Framalibre: "
    :one-sw                  "Software"
    :read-the-docs           "Dokumentation leseen"
    :recommended             "Empfohlen"
    :recommended_version     "Empfohlene Mindestversion"
    :similar-to              "Ähnlich zu"
    :sort-alpha              "A-Z <=> Z-A"
    :source-code-available   ", Sourcecode verfügbar "
    :stats                   "Statistiken"
    :status                  "Status"
    :submit                  "Abschicken"
    :subscribe-rss-flux      "RSS feed"
    :sws                     "Software"
    :tested                  "In Beobachtung"
    :unspecified             "Nicht spezifiziert"
    :updates                 "Updates"
    :version                 "Version: "
    :warning-testing         "Evaluierung dieser Software noch nicht abgeshlossen."
    :website-developed-by    "Webseite entwickelt von "
    :why-this-website?       "Warum diese Webseite?"
    :year                    "Jahr"
    :your-affiliation        "Organisation"
    :your-email              "Email-Adresse"
    :your-message            "Nachricht"
    :your-name               "Name"
    }
   :es
   {
    :public                  "Este software es apoyado y financiado por la administración pública."
    :about                   "Sobre nosotros"
    :affiliation-placeholder "E.g. DGFiP"
    :all                     "Todo"
    :back-to-website         "Volver a la web principal"
    :clear-filters           "Reiniciar filtros"
    :contact                 "Contacto"
    :contact-baseline        "¿Quieres contribuir? ¿Una pregunta? ¡Contactanos!"
    :contact-by-email        "Contacto por email"
    :contact-form            "Formulario de contacto"
    :context-of-use          "Contexto de uso:"
    :contributors            "Contribuidores"
    :contributors-baseline   "Lita de agencias del sector público contribuyentes"
    :count                   "Cantidad"
    :download                "Descargar"
    :email-placeholder       "E.g. toto@modernisation.gouv.fr"
    :free-search             "Busqueda libre"
    :function                "Función:"
    :go-to-source            "Navega al código fuente"
    :go-to-website           "Visita el sitio web"
    :groupe                  "Grupo"
    :groups-count            "Distribución por grupo"
    :here                    "aquí"
    :index-subtitle          "Este sitio web te permite buscar en el catalogo de programas de uso gratuito recomendados para el sector público."
    :index-title             "Programas de uso gratuito recomendados para el sector público"
    :keywords                "Lista de programas recomendados por el sector público"
    :license                 "Licencia"
    :licenses                "Licencias"
    :licenses-count          "Distribución por licencia"
    :main-etalab-website     "Web principal de etalab"
    :message-placeholder     "Tu mensaje"
    :message-received        "¡Mensaje recibido!"
    :message-received-ok     "Te responderemos lo más rápido posible."
    :mimall                  "Todos los tipos"
    :mimdev                  "Herramientas de desarrollo"
    :mimo                    "Herramientas de oficina"
    :mimprod                 "Herramientas de producción"
    :name                    "Nombre"
    :need-more-data          "¿Obtenga más información sobre el uso de este software?  [¡Contactanos!](contact)"
    :no-sws-found            "No se encontraoron programas, intenta de otra manera"
    :on-comptoir             "En Comptoir du libre"
    :on-framalibre           "En Framalibre: "
    :one-sw                  "programas"
    :read-the-docs           "Leer la documentación"
    :recommended             "Recomendado"
    :recommended_version     "Versión mínima recomendada"
    :similar-to              "Similar a"
    :sort-alpha              "A-Z <=> Z-A"
    :source-code-available   ", código fuente disponible "
    :stats                   "Estadística"
    :status                  "Estado"
    :submit                  "Enviar"
    :subscribe-rss-flux      "RSS feed"
    :sws                     "programas"
    :tested                  "En observación"
    :unspecified             "No especificado"
    :updates                 "Actualizaciones"
    :version                 "Versión: "
    :warning-testing         "Este programa esta siendo actualmente testado."
    :website-developed-by    "Sitio web desarrollado por "
    :why-this-website?       "¿Por qué este sitio web?"
    :year                    "Año"
    :your-affiliation        "Tu asociación"
    :your-email              "Tu correo electrónico"
    :your-message            "Mensaje"
    :your-name               "Tu nombre"
    }
   :it
   {
    :public                  "Questo software è supportato e finanziato dalla pubblica amministrazione."
    :about                   "Chi siamo"
    :affiliation-placeholder "E.g. DGFiP"
    :all                     "Tutti"
    :back-to-website         "Torna al sito principale."
    :clear-filters           "Azzera filtri."
    :contact                 "Contatta"
    :contact-baseline        "Vuoi contribuire? Domande? Contattaci!"
    :contact-by-email        "Contattaci via email"
    :contact-form            "Modulo di contatto"
    :context-of-use          "Contesto d'uso:"
    :contributors            "Contributori"
    :contributors-baseline   "Lista delle pubbliche amministrazioni che hanno contribuito"
    :count                   "Quantità"
    :download                "Scarica"
    :email-placeholder       "E.g. toto@modernisation.gouv.fr"
    :free-search             "Ricerca libera"
    :function                "Funzione:"
    :go-to-source            "Naviga nel codice sorgente"
    :go-to-website           "Visita il sito web"
    :groupe                  "Gruppo"
    :groups-count            "Conta per gruppo"
    :here                    "qui"
    :index-subtitle          "Questo sito web consente di consultare il catalogo dei software liberi consigliati per il settore pubblico."
    :index-title             "Software libero consigliato per il settore pubblico"
    :keywords                "Lista del software consigliato per la pubblica amministrazione"
    :license                 "Licenza"
    :licenses                "Licenze"
    :licenses-count          "Dichiarazione di licenza"
    :main-etalab-website     "Sito principale di Etalab"
    :message-placeholder     "Tuo messaggio"
    :message-received        "Messaggi ricevuti!"
    :message-received-ok     "Risponderemo appena possibile."
    :mimall                  "Tutte le tipologie"
    :mimdev                  "Strumenti di sviluppo"
    :mimo                    "Strumenti Office tools"
    :mimprod                 "Production tools"
    :name                    "Nome"
    :need-more-data          "Ulteriori informazioni sull'uso di questo software? [Contattaci!](contact)"
    :no-sws-found            "Non ho trovato software: prova con un'altra ricerca?"
    :on-comptoir             "Su Comptoir du libre"
    :on-framalibre           "Su Framalibre: "
    :one-sw                  "software"
    :read-the-docs           "Leggi la documentazione"
    :recommended             "Consigliato"
    :recommended_version     "Versione minima consigliata"
    :similar-to              "Simile a"
    :sort-alpha              "A-Z <=> Z-A"
    :source-code-available   ", codice sorgente disponibile "
    :stats                   "Statistica"
    :status                  "Stato"
    :submit                  "Inviato"
    :subscribe-rss-flux      "RSS feed"
    :sws                     "software"
    :tested                  "Sotto osservazione"
    :unspecified             "Imprecisato"
    :updates                 "Aggiornamenti"
    :version                 "Versione: "
    :warning-testing         "Questo software è attualmente sotto test."
    :website-developed-by    "Sito web realizzato da "
    :why-this-website?       "Perchè questo sito?"
    :year                    "Anno"
    :your-affiliation        "Tua affiliazione"
    :your-email              "Tuo indirizzo email"
    :your-message            "Messaggio"
    :your-name               "Tuo nome"
    }
   })

(def opts {:dict localization})

(defn i [lang input] (tr opts [lang] input))
