    package com.example.trocker2;

    import androidx.annotation.NonNull;
    import androidx.fragment.app.Fragment;
    import androidx.fragment.app.FragmentManager;
    import androidx.fragment.app.FragmentStatePagerAdapter;

    import java.util.ArrayList;
    import java.util.List;

    public class PageAdapteurPoduit extends FragmentStatePagerAdapter {
        private List<Fragment> fragments = new ArrayList<>();

        public PageAdapteurPoduit(@NonNull FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment) {
            fragments.add(fragment);
            notifyDataSetChanged();
        }

        public void removeFragment(int position) {
            Fragment fragment = getItem(position);
            System.out.println("remove frag");
            if (fragments.contains(fragment)) {
                System.out.println("contain frag");
                if (position >= 0 && position <= fragments.size()) {
                    System.out.println("Bonne position");
                    if (getItemPosition(fragment) != POSITION_NONE) {
                        System.out.println("get une bonne position frag");
                        fragments.remove(position);
                        notifyDataSetChanged();
                    }
                }
            }
        }

        public void addFragmentAt(Fragment fragment, int position){
            if (!fragments.contains(fragment)) {
                System.out.println("remove frag");
                if(position >= 0 && position <= fragments.size()) {
                    System.out.println("good index frag");
                    fragments.add(position, fragment);
                    notifyDataSetChanged();
                } else {
                    throw new IllegalArgumentException("Invalid position: " + position);
                }
            }
        }

        public void deplacerFragment(Fragment fragment, int position){
            if (!fragments.contains(fragment)) {
                fragments.remove(fragments.indexOf(fragment));

                if (position < fragments.size()) {
                    fragments.add(position, fragment);
                } else {
                    fragments.add(fragment);
                }

                // Mettre à jour la liste de l'adaptateur et afficher les fragments dans le nouvel ordre
                notifyDataSetChanged();
            }
        }

        @Override
        public Fragment getItem(int position) {
            if (position < fragments.size()) {
                return fragments.get(position);
            }
            return null;
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            // Retourne la position actuelle de l'objet
            int index = fragments.indexOf(object);
            if (index == -1) {
                return POSITION_NONE;
            } else {
                return index;
            }
        }
    }
