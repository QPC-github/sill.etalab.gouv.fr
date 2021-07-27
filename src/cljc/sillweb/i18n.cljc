;; Copyright (c) 2019-2021 DINSIC, Bastien Guerry <bastien.guerry@data.gouv.fr>
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
    :about                   "À propos"
    :affiliation-placeholder "Par ex. DGFiP"
    :agency                  "Organisme porteur"
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
    :download-csv            "Télécharger CSV"
    :download-pdf            "Télécharger PDF"
    :email-placeholder       "Par ex. toto@modernisation.gouv.fr"
    :free-search             "Recherche libre"
    :freesoftware            "Logiciel libre"
    :function                "Fonction :"
    :go-to-source            "Voir le code source"
    :go-to-website           "Visiter le site web"
    :group                   "Groupe"
    :groups-count            "Décompte par groupe"
    :here                    "ici"
    :index-subtitle          "Le catalogue de référence pour les administrations"
    :index-title             "Socle Interministériel de Logiciels Libres"
    :instances               "Instances"
    :keywords                "Catalogue de référence des logiciels libres pour les administrations"
    :label                   "Présent dans le catalogue GouvTech"
    :license                 "Licence"
    :license-title           "Lire la licence"
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
    :papillon                "« PAPILLON » désigne le Portail Administratif des Plateformes Intégrant des Logiciels Libres et Ouvertes au plus grand Nombre.  Concrètement, il s'agit des services en ligne du secteur public qui s'appuient sur un logiciel libre clairement identifié.  Vous pouvez [contribuer à PAPILLON ici](https://github.com/etalab/papillon/) et télécharger le [fichier csv](https://raw.githubusercontent.com/etalab/papillon/master/papillon.csv)."
    :permalink               "Lien permanent"
    :public                  "Ce logiciel est développé et financé par l'administration publique."
    :public-sector-websites  "Les sites publics : "
    :read-the-docs           "Lire la documentation"
    :recommended             "Recommandés"
    :recommended_version     "Version recommandée"
    :similar-to              "Similaire à"
    :sort-alpha              "A <=> Z"
    :source-code-available   ", code source disponible "
    :stats                   "Statistiques"
    :status                  "Statut"
    :submit                  "Envoyer"
    :subscribe-rss-flux      "S'abonner au flux RSS des derniers dépôts"
    :subscription            "Inscription"
    :supported               "Ce logiciel est couvert par le marché de support interministériel."
    :sws                     "logiciels"
    :tested                  "En observation"
    :unspecified             "Non spécifié"
    :updates                 "Mises à jour"
    :users                   "Usagers"
    :version                 "Version: "
    :warning-testing         "Ce logiciel est actuellement en observation."
    :warning-end             "Ce logiciel n'est plus recommandé."
    :website-developed-by    "Site développé par "
    :why-this-website?       "Pourquoi ce site ?"
    :year                    "Année"
    :years-count             "Répartition par an"
    :your-affiliation        "Votre organisme de rattachement"
    :your-email              "Votre adresse de courriel"
    :your-message            "Message"
    :your-name               "Votre nom"
    }
   :en
   {
    :about                   "About"
    :affiliation-placeholder "E.g. DGFiP"
    :agency                  "Agency"
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
    :download-csv            "Download CSV"
    :download-pdf            "Download PDF"
    :email-placeholder       "E.g. toto@modernisation.gouv.fr"
    :free-search             "Free search"
    :freesoftware            "Free software"
    :function                "Function:"
    :go-to-source            "Browse the source code"
    :go-to-website           "Visit the website"
    :group                   "Group"
    :groups-count            "Count by group"
    :here                    "here"
    :index-subtitle          "The catalog of recommended free software for the french public sector"
    :index-title             "Recommended free software for the public sector"
    :instances               "Instances"
    :keywords                "List of recommended software by the public sector"
    :label                   "Listed in the GouvTech catalog"
    :license                 "License"
    :license-title           "Read the license"
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
    :papillon                "PAPILLON is the Administrative Portal of Platforms Relying on Free Software.  Concretely, it is a list of online services of the public sector which are based on a clearly identified free software."
    :permalink               "Permalink"
    :public                  "This software is managed and funded by the french administration."
    :public-sector-websites  "Public sector websites: "
    :read-the-docs           "Read the documentation"
    :recommended             "Recommended"
    :recommended_version     "Minimal recommended version"
    :similar-to              "Similar to"
    :sort-alpha              "A-Z <=> Z-A"
    :source-code-available   ", source code available "
    :stats                   "Statistics"
    :submit                  "Send"
    :subscribe-rss-flux      "Subscribe to the latest updates via RSS feed"
    :subscription            "Subscription"
    :supported               "This software is listed among those for which some public agencies may easily buy support."
    :sws                     "software"
    :tested                  "Under observation"
    :unspecified             "Unspecified"
    :updates                 "Updates"
    :users                   "Users"
    :version                 "Version: "
    :warning-testing         "This software is currently being tested."
    :warning-end             "This software is not recommended anymore."
    :website-developed-by    "Website developed by "
    :why-this-website?       "Why this website?"
    :year                    "Year"
    :years-count             "Distribution over the years"
    :your-affiliation        "Your affiliation"
    :your-email              "Your email address"
    :your-message            "Message"
    :your-name               "Your name"
    }
   :de
   {
    :about                   "Über uns"
    :affiliation-placeholder "z.B. DGFiP"
    :agency                  "Public agency"
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
    :download-csv            "Download CSV"
    :download-pdf            "Download PDF"
    :email-placeholder       "z.B. toto@modernisation.gouv.fr"
    :free-search             "Freie Suche"
    :freesoftware            "Free software"
    :function                "Funktion:"
    :go-to-source            "Quellcode sehen"
    :go-to-website           "Webseite besuchen"
    :group                   "Gruppe"
    :groups-count            "Nach Gruppe zählen"
    :here                    "hier"
    :index-subtitle          "Eine Liste aller freier Software, die in der öffentlichen Verwaltung regelmässig genutzt wird"
    :index-title             "Empfohlene open source Software für die öffentliche Verwaltung"
    :instances               "Instances"
    :keywords                "Empfohlene open source Software für die öffentliche Verwaltung"
    :label                   "Im GouvTech Katalog enthalten"
    :license                 "Lizenz"
    :license-title           "Lizenz reden"
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
    :papillon                "\"PAPILLON\" bezeichnet das Verwaltungsportal der Plattformen, die freie und offene Software in größtmöglicher Zahl integrieren. Konkret geht es um Online-Dienste des öffentlichen Sektors, die sich auf eine klar identifizierte freie Software stützen."
    :permalink               "Permalink" ;; TODO
    :public                  "Dieses Software wird von der öffentlichen Verwaltung unterstützt und finanziert."
    :public-sector-websites  "Websites der öffentlichen Verwaltung: "
    :read-the-docs           "Dokumentation leseen"
    :recommended             "Empfohlen"
    :recommended_version     "Empfohlene Mindestversion"
    :similar-to              "Ähnlich zu"
    :sort-alpha              "A-Z <=> Z-A"
    :source-code-available   ", Sourcecode verfügbar "
    :stats                   "Statistiken"
    :submit                  "Abschicken"
    :subscribe-rss-flux      "RSS feed"
    :subscription            "Abonnement"
    :supported               "Diese Software ist unter denjenigen aufgeführt, für die einige Agenturen möglicherweise problemlos Support kaufen."
    :sws                     "Software"
    :tested                  "In Beobachtung"
    :unspecified             "Nicht spezifiziert"
    :updates                 "Updates"
    :users                   "Benutzer"
    :version                 "Version: "
    :warning-testing         "Evaluierung dieser Software noch nicht abgeshlossen."
    :warning-end             "Diese Software wird nicht mehr empfohlen."
    :website-developed-by    "Webseite entwickelt von "
    :why-this-website?       "Warum diese Webseite?"
    :year                    "Jahr"
    :years-count             "Aufschlüsselung nach Jahr"
    :your-affiliation        "Organisation"
    :your-email              "Email-Adresse"
    :your-message            "Nachricht"
    :your-name               "Name"
    }
   :es
   {
    :about                   "Sobre nosotros"
    :affiliation-placeholder "E.g. DGFiP"
    :agency                  "Agencia del gobierno"
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
    :download-csv            "Descargar CSV"
    :download-pdf            "Descargar PDF"
    :email-placeholder       "E.g. toto@modernisation.gouv.fr"
    :free-search             "Busqueda libre"
    :freesoftware            "Free software"
    :function                "Función:"
    :go-to-source            "Navega al código fuente"
    :go-to-website           "Visita el sitio web"
    :group                   "Grupo"
    :groups-count            "Distribución por grupo"
    :here                    "aquí"
    :index-subtitle          "Este sitio web te permite buscar en el catalogo de programas de uso gratuito recomendados para el sector público"
    :index-title             "Programas de uso gratuito recomendados para el sector público"
    :instances               "Instances"
    :keywords                "Lista de programas recomendados por el sector público"
    :label                   "Incluido en el catálogo de GouvTech"
    :license                 "Licencia"
    :license-title           "Lee la licencia"
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
    :papillon                "PAPILLÓN designa el Portal Administrativo de Plataformas Integradoras de Software Libre y Abierto al mayor número.  Concretamente, se trata de servicios en línea del sector público que dependen de un software libre claramente identificado."
    :permalink               "Permalink" ;; TODO
    :public                  "Este software es apoyado y financiado por la administración pública."
    :public-sector-websites  "Sitios web de administración pública: "
    :read-the-docs           "Leer la documentación"
    :recommended             "Recomendado"
    :recommended_version     "Versión mínima recomendada"
    :similar-to              "Similar a"
    :sort-alpha              "A-Z <=> Z-A"
    :source-code-available   ", código fuente disponible "
    :stats                   "Estadística"
    :submit                  "Enviar"
    :subscribe-rss-flux      "RSS feed"
    :subscription            "Suscripción"
    :supported               "Este software figura entre aquellos para los que algunas agencias pueden comprar fácilmente soporte."
    :sws                     "programas"
    :tested                  "En observación"
    :unspecified             "No especificado"
    :updates                 "Actualizaciones"
    :users                   "Usuarios"
    :version                 "Versión: "
    :warning-testing         "Este programa esta siendo actualmente testado."
    :warning-end             "Este software ya no se recomienda."
    :website-developed-by    "Sitio web desarrollado por "
    :why-this-website?       "¿Por qué este sitio web?"
    :year                    "Año"
    :years-count             "Desglose por año"
    :your-affiliation        "Tu asociación"
    :your-email              "Tu correo electrónico"
    :your-message            "Mensaje"
    :your-name               "Tu nombre"
    }
   :it
   {
    :about                   "Chi siamo"
    :affiliation-placeholder "E.g. DGFiP"
    :agency                  "Agenzia governativa"
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
    :download-csv            "Scarica CSV"
    :download-pdf            "Scarica PDF"
    :email-placeholder       "E.g. toto@modernisation.gouv.fr"
    :free-search             "Ricerca libera"
    :freesoftware            "Free software"
    :function                "Funzione:"
    :go-to-source            "Naviga nel codice sorgente"
    :go-to-website           "Visita il sito web"
    :group                   "Gruppo"
    :groups-count            "Conta per gruppo"
    :here                    "qui"
    :index-subtitle          "Questo sito web consente di consultare il catalogo dei software liberi consigliati per il settore pubblico"
    :index-title             "Software libero consigliato per il settore pubblico"
    :instances               "Instances"
    :keywords                "Lista del software consigliato per la pubblica amministrazione"
    :label                   "Incluso nel catalogo GouvTech"
    :license                 "Licenza"
    :license-title           "Leggi la licenza"
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
    :papillon                "\"PAPILLON\" designa il portale amministrativo delle piattaforme che integrano il software libero e aperto al maggior numero possibile. Concretamente, si tratta di servizi online del settore pubblico che si basano su un software libero chiaramente identificato."
    :permalink               "Permalink" ;; TODO
    :public                  "Questo software è supportato e finanziato dalla pubblica amministrazione."
    :public-sector-websites  "Siti Web della pubblica amministrazione: "
    :read-the-docs           "Leggi la documentazione"
    :recommended             "Consigliato"
    :recommended_version     "Versione minima consigliata"
    :similar-to              "Simile a"
    :sort-alpha              "A-Z <=> Z-A"
    :source-code-available   ", codice sorgente disponibile "
    :stats                   "Statistica"
    :submit                  "Inviato"
    :subscribe-rss-flux      "RSS feed"
    :subscription            "Abbonamento"
    :supported               "Questo software è elencato tra quelli per i quali alcune agenzie possono facilmente acquistare supporto. "
    :sws                     "software"
    :tested                  "Sotto osservazione"
    :unspecified             "Imprecisato"
    :updates                 "Aggiornamenti"
    :users                   "Utenti"
    :version                 "Versione: "
    :warning-testing         "Questo software è attualmente sotto test."
    :warning-end             "Questo software non è più consigliato."
    :website-developed-by    "Sito web realizzato da "
    :why-this-website?       "Perchè questo sito?"
    :year                    "Anno"
    :years-count             "Ripartizione per anno"
    :your-affiliation        "Tua affiliazione"
    :your-email              "Tuo indirizzo email"
    :your-message            "Messaggio"
    :your-name               "Tuo nome"
    }
   })

(def opts {:dict localization})

(defn i [lang input] (tr opts [lang] input))
