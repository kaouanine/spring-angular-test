import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouteArticleComponent } from './ajoute-article.component';

describe('AjouteArticleComponent', () => {
  let component: AjouteArticleComponent;
  let fixture: ComponentFixture<AjouteArticleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AjouteArticleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AjouteArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
