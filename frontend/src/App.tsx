import { useState } from "react";
import "./App.css";

type ContentType = "post" | "photo" | "file";

interface Content {
  id: number;
  type: ContentType;
  title: string;
  description?: string;
  date: string;
  meta?: string;
  image?: string;
}

const contents: Content[] = [
  {
    id: 1,
    type: "post",
    title: "요즘의 기록",
    description:
      "최근에 했던 일들과 앞으로 하고 싶은 것들을 간단하게 정리해봤다.",
    date: "오늘",
    meta: "글 · 5분",
  },
  {
    id: 2,
    type: "photo",
    title: "제주도 여행",
    date: "어제",
    meta: "사진 24장",
    image:
      "https://images.unsplash.com/photo-1473116763249-2faaef81ccda?w=800",
  },
  {
    id: 3,
    type: "file",
    title: "프로젝트 기획서.pdf",
    date: "09.15",
    meta: "2.4 MB",
  },
  {
    id: 4,
    type: "post",
    title: "Spring Boot 정리",
    description: "JPA와 QueryDSL을 공부하면서 정리한 내용.",
    date: "09.14",
    meta: "개발 · 글",
  },
  {
    id: 5,
    type: "photo",
    title: "일상의 순간",
    date: "09.12",
    meta: "사진 12장",
    image:
      "https://images.unsplash.com/photo-1490730141103-6cac27aaab94?w=800",
  },
];

const folders = [
  { name: "개발", count: 12, icon: "⌁" },
  { name: "여행", count: 24, icon: "○" },
  { name: "일상", count: 8, icon: "◇" },
  { name: "자료", count: 16, icon: "□" },
];

function App() {
  const [activeFilter, setActiveFilter] = useState<"all" | ContentType>("all");
  const [showAdd, setShowAdd] = useState(false);

  const filteredContents =
    activeFilter === "all"
      ? contents
      : contents.filter((content) => content.type === activeFilter);

  return (
    <div className="app">
      {/* Header */}
      <header className="header">
        <div className="brand">
          <div className="brand-mark">h</div>
          <span>한켠</span>
        </div>

        <nav className="nav">
          <a className="active">홈</a>
          <a>둘러보기</a>
          <a>기록</a>
          <a>사진</a>
          <a>파일</a>
        </nav>

        <div className="header-right">
          <button className="search">
            <span>⌕</span>
            <span>검색</span>
            <kbd>⌘ K</kbd>
          </button>

          <button className="profile">
            <div className="avatar">경</div>
            <span>경천</span>
            <span className="chevron">⌄</span>
          </button>
        </div>
      </header>

      {/* Main */}
      <main className="main">
        {/* Hero */}
        <section className="hero">
          <div>
            <p className="eyebrow">MY SPACE · 2026</p>

            <h1>
              나의 작은 공간,
              <br />
              <span>나의 모든 것.</span>
            </h1>

            <p className="hero-description">
              생각을 기록하고, 사진을 남기고,
              <br />
              필요한 것들을 이곳에 보관하세요.
            </p>
          </div>

          <button
            className="add-button"
            onClick={() => setShowAdd(!showAdd)}
          >
            <span>+</span>
            새로운 기록
          </button>

          {showAdd && (
            <div className="add-menu">
              <button>
                <span>✎</span>
                <div>
                  <strong>새 글</strong>
                  <small>생각과 기록을 남겨요</small>
                </div>
              </button>

              <button>
                <span>▧</span>
                <div>
                  <strong>사진 업로드</strong>
                  <small>사진을 공간에 추가해요</small>
                </div>
              </button>

              <button>
                <span>□</span>
                <div>
                  <strong>파일 업로드</strong>
                  <small>파일을 안전하게 보관해요</small>
                </div>
              </button>
            </div>
          )}
        </section>

        {/* Content */}
        <section className="content-section">
          <div className="section-header">
            <div>
              <h2>최근의 흔적</h2>
              <p>최근 이 공간에 추가된 것들</p>
            </div>

            <button className="text-button">모두 보기 →</button>
          </div>

          <div className="filter">
            {[
              ["all", "전체"],
              ["post", "기록"],
              ["photo", "사진"],
              ["file", "파일"],
            ].map(([value, label]) => (
              <button
                key={value}
                className={activeFilter === value ? "selected" : ""}
                onClick={() =>
                  setActiveFilter(value as "all" | ContentType)
                }
              >
                {label}
              </button>
            ))}
          </div>

          <div className="content-grid">
            {filteredContents.map((content) => (
              <ContentCard key={content.id} content={content} />
            ))}
          </div>
        </section>

        {/* Bottom */}
        <section className="bottom-grid">
          {/* Folders */}
          <div className="panel">
            <div className="panel-header">
              <div>
                <h2>내 공간</h2>
                <p>정리해둔 장소들</p>
              </div>

              <button className="circle-button">+</button>
            </div>

            <div className="folder-list">
              {folders.map((folder) => (
                <div className="folder" key={folder.name}>
                  <div className="folder-icon">{folder.icon}</div>

                  <div className="folder-info">
                    <strong>{folder.name}</strong>
                    <span>{folder.count}개의 항목</span>
                  </div>

                  <span className="folder-arrow">→</span>
                </div>
              ))}
            </div>
          </div>

          {/* Quote / Note */}
          <div className="note">
            <div className="note-top">
              <span>오늘의 메모</span>
              <span>•••</span>
            </div>

            <div className="note-content">
              <p>
                "무언가를 남겨두는 것은
                <br />
                지나간 시간을 붙잡는
                <br />
                작은 방법이다."
              </p>
            </div>

            <div className="note-date">2026. 09. 18</div>
          </div>
        </section>
      </main>

      <footer>
        <span>한켠</span>
        <span>나만의 공간에 머무는 시간</span>
      </footer>
    </div>
  );
}

function ContentCard({ content }: { content: Content }) {
  if (content.type === "photo") {
    return (
      <article className="content-card photo-card">
        <div className="photo-wrapper">
          <img src={content.image} alt={content.title} />

          <div className="photo-overlay">
            <span>{content.meta}</span>
          </div>
        </div>

        <div className="card-info">
          <span className="content-type">PHOTO</span>
          <h3>{content.title}</h3>
          <p>{content.date}</p>
        </div>
      </article>
    );
  }

  if (content.type === "file") {
    return (
      <article className="content-card file-card">
        <div className="file-preview">
          <div className="file-icon">PDF</div>
          <span className="file-more">•••</span>
        </div>

        <div className="card-info">
          <span className="content-type">FILE</span>
          <h3>{content.title}</h3>
          <p>
            {content.meta} · {content.date}
          </p>
        </div>
      </article>
    );
  }

  return (
    <article className="content-card post-card">
      <div className="post-top">
        <span className="post-symbol">✎</span>
        <span>{content.date}</span>
      </div>

      <div className="post-body">
        <span className="content-type">NOTE</span>
        <h3>{content.title}</h3>
        <p>{content.description}</p>
      </div>

      <div className="post-footer">
        <span>{content.meta}</span>
        <span>→</span>
      </div>
    </article>
  );
}

export default App;