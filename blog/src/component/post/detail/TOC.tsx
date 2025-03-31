export interface TOCItem {
  id: string;
  text: string;
  level: number;
}

const getIndentClass = (level: number) => {
  switch (level) {
    case 2:
      return "ml-2";
    case 3:
      return "ml-5";
    case 4:
      return "ml-8";
    default:
      return "ml-0";
  }
};

export default function TOC({items, activeId}: { items: TOCItem[], activeId: string | null }) {

  return (
      <nav>
        <ul className="text-sm">
          {items.map(item => (
              <li key={item.id} className={`ml-${(item.level - 1) * 4}`}>
                <a
                    key={item.id}
                    href={`#${item.id}`}
                    className={`block ${getIndentClass(item.level)} hover:underline ${
                        activeId === item.id ? "text-blue-500 font-semibold" : "text-gray-700"
                    }`}
                >
                  {item.text}
                </a>
              </li>
          ))}
        </ul>
      </nav>
  )
}
