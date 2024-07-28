import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  standalone: true,
  name: 'findLanguageFromKey',
})
export default class FindLanguageFromKeyPipe implements PipeTransform {
  private readonly languages: { [key: string]: { name: string; rtl?: boolean } } = {
    en: { name: 'English' },
    nl: { name: 'Nederlands' },
    fr: { name: 'Français' },
    de: { name: 'Deutsch' },
    hi: { name: 'हिंदी' },
    id: { name: 'Bahasa Indonesia' },
    it: { name: 'Italiano' },
    ja: { name: '日本語' },
    ko: { name: '한국어' },
    'pt-pt': { name: 'Português' },
    es: { name: 'Español' },
    tr: { name: 'Türkçe' },
    th: { name: 'ไทย' },
    vi: { name: 'Tiếng Việt' },
    // jhipster-needle-i18n-language-key-pipe - JHipster will add/remove languages in this object
  };

  transform(lang: string): string {
    return this.languages[lang].name;
  }
}
