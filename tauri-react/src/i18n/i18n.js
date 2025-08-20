import i18n from 'i18next';
import { initReactI18next } from 'react-i18next';

import en from './en.json';
import ru from './ru.json';

i18n
    .use(initReactI18next) // ✅ This binds i18n instance to react-i18next
    .init({
        resources: {
            en: { translation: en },
            ru: { translation: ru }
        },
        lng: 'en', // or use navigator.language
        fallbackLng: 'en',
        interpolation: {
            escapeValue: false // react already does escaping
        }
    });

export default i18n;
