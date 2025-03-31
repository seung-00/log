type Props = {
  children: React.ReactNode
}

export default function PageContainer({children}: Props) {

  return (
      <div className="page_container">
        {children}
      </div>
  )
}
